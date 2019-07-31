package bczm.com.mvpokdemo.protocol;

import bczm.com.mvpokdemo.AppConfig;

public final class UrlPathMaker {
	
	public  enum URL_ENUM {
		
		//------------福利类型--------------

		//妹子图
		HttpUrlTypeWelfare ,

	};
	
	private static String getUrlWithInnerParam(String...params){
		String paramsStr = "";
		
		if (params==null || params.length == 0) {
			return paramsStr;
		}
		
		for (int i = 0; i < params.length; i++) {
			if (i != 0) {
				paramsStr = paramsStr +"/" + params[i].trim();
			}else {
				paramsStr = paramsStr + params[i].trim();
			}
		}
		return paramsStr;
	}
	
	public static String get_url(URL_ENUM type){
		return get_url(type, "") ; 
	}
	
	public static String get_url(URL_ENUM type,String...params){
		String url = "";
	    switch (type){
	        //==================================================获取福利
	        case HttpUrlTypeWelfare:
	        {
	            url = AppConfig.API_GANK_BASE+"api/data/福利/"+getUrlWithInnerParam(params);
	        }
	            break;
	        //==================================================注册接口
	        default:
	        	break;
	    }
	    return url;
	}
	
	
	
}
