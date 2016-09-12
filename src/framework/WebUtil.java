package framework;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import kr.co.mlec.board.Board;

public class WebUtil {
	public static Object getParamToVo (Class<?> clz, HttpServletRequest request ) throws Exception{
		//메서드 실행을 위한 target object 
		Object obj = clz.newInstance();
		//clz 클래스 정보에 있는 모든 메서드를 가져온다.
		
		Method[] mArr = clz.getDeclaredMethods();
			for(Method m : mArr){
				
				String mName = m.getName();
				if(!mName.startsWith("set")) continue;
				mName = mName.substring("set".length());
				mName = Character.toLowerCase(mName.charAt(0)) +mName.substring(1);
		//set 메서드에 해당하는 파라미터 가져오기
				String pValue = request.getParameter(mName);
				if(pValue == null) continue;
		//set 메서드에 설정할 값이 파라미터에 존재함
				
		//메서드를 실행하기
		//메서드 객체 : m, 인스턴스 객체 : obj 
				String pName = m.getParameterTypes()[0].getName();
				switch(pName){
				case "int" :
					m.invoke(obj, Integer.parseInt(pValue));
					break;
				default :
					m.invoke(obj, pValue);
					break;
				}
			}
		
		return obj;
	}
}
