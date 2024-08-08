package com.itwill.springboot5.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
// onlyExplicitlyIncluded 속성: @EqualsAndHashCode.Include 애너테이션이 설정된 필드만 
// 사용할 것인 지 여부.
// callSuper 속성: superclass의 equals(), hashCode() 메서드를 사용할 것인 지 여부.
@Entity
@Table(name = "MEMBERS")
public class Member extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @EqualsAndHashCode.Include // username 필드를 equals()와 hashCode()를 재정의할 때 사용.
    @NaturalId // unique 제약조건
    @Basic(optional = false) // not null 제약조건
    @Column(updatable = false) // update 쿼리에서 set 절에서 제외하기 위해서.
    private String username;
    
    @Basic(optional = false)
    private String password;
    
    @Basic(optional = false)
    private String email;
    
    @Builder.Default // Builder 패턴에서도 null이 아닌 HashSet<> 객체로 초기화될 수 있도록.
    @ToString.Exclude // toString() 메서드에서 제외.
    @ElementCollection(fetch = FetchType.LAZY) // 연관 테이블(member_roles) 사용.
    @Enumerated(EnumType.STRING) // DB 테이블에 저장될 때 상수(enum) 이름(문자열)을 사용.
    private Set<MemberRole> roles = new HashSet<>();
    
    public Member addRole(MemberRole role) {
        roles.add(role); // Set<>에 원소를 추가.
        return this;
    }
    
    public Member removeRole(MemberRole role) {
        roles.remove(role); // Set<>에서 원소(role)를 삭제.
        return this;
    }
    
    public Member clearRoles() {
        roles.clear(); // Set<>의 모든 원소를 지움.
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (MemberRole r : roles) {
//            GrantedAuthority auth = new SimpleGrantedAuthority(r.getAuthority());
//            authorities.add(auth);
//        }
        
        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map((r) -> new SimpleGrantedAuthority(r.getAuthority()))
                .toList();
        
        return authorities;
    }
    
}
