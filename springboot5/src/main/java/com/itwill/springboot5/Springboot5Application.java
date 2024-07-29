package com.itwill.springboot5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
 * insert/update 쿼리를 실행할 때 시간을 자동으로 저장:
 * 엔터티의 생성/수정 시간을 자동으로 기록하기 위해서 JPA Auditing 기능을 활성화시킴.
 * (1) 메인 클래스(Springboot5Application)에서 @EnableJpaAuditing 애너테이션을 설정.
 * (2) 날짜/시간(LocalDate/LocalDateTime) 필드를 갖는 엔터티(BaseTimeEntity)에서
 * @EntityListeners(AuditingEntityListener.class) 애너테이션을 설정.
 * (3) 날짜/시간 필드(createdTime, modifiedTime)에 @CreatedDate, @LastModifiedDate 애너테이션 설정. 
 */
@EnableJpaAuditing // JPA Auditing 기능 활성화.
//-> AuditingEntityListener를 사용할 수 있게 설정.
@SpringBootApplication
public class Springboot5Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot5Application.class, args);
	}

}
