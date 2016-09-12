package framework;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class URLHandleMapping {
	private Map<String,CtrlAndMethod> mappings;
	public URLHandleMapping(){}
	public URLHandleMapping(String ctrlNames) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		mappings = new HashMap<>();
		
		/*
		 * kr.co.mlec.board.controller.BoardController;
		 * kr.co.mlec.board.controller.BoardController
		 */
		String[] ctrlList= ctrlNames.split(";");
		for(String ctrlName : ctrlList){
			
			Class<?> clz = Class.forName(ctrlName.trim());
			Object target = clz.newInstance();
			
			//clz안에 존재하는 모든 매서드를 추출한다.
			Method[] mArr = clz.getDeclaredMethods();
			// 반복을 진행하면서 매서드의 URI정보추출, 해당하는 객체와 실행 매서드정보를 맵에 저장
			for(Method method : mArr){
				RequestMapping rm = method.getAnnotation(RequestMapping.class);
				if(rm==null) continue;
				mappings.put(rm.value(), new CtrlAndMethod(target,method));
				
			}
			
		}
			
	}

	public CtrlAndMethod getCtrlAndMethod (String requestUri) {
		
		return mappings.get(requestUri);
	}
}
