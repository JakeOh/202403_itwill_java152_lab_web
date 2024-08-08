package com.itwill.springboot5.domain;

public enum MemberRole {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    GUEST("ROLE_GUEST");
    
    private String authority;
    
    // 주의: enum의 생성자는 항상 private. private 수식어는 생략함.
    MemberRole(String authority) {
        this.authority = authority;
    }
    
    public String getAuthority() {
        return this.authority;
    }
}
