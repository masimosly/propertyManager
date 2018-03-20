package cn.com.fourwind.propertyManager.security;

import org.springframework.security.core.GrantedAuthority;

public class MyGrantedAuthority implements GrantedAuthority{
	private static final long serialVersionUID = -949136440088599020L;
	private String authority;

    public MyGrantedAuthority(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
