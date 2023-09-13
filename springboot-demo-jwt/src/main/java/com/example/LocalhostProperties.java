package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author LiuYunLong
 */

@Component
@ConfigurationProperties(prefix = "localhost")
public class LocalhostProperties {


	 @Value("user")
	 private String user;

	 public String getUser() {
		  return user;
	 }

	 public void setUser(String user) {
		  this.user = user;
	 }

	 @Override
	 public boolean equals(Object o) {
		  if (this == o) return true;
		  if (!(o instanceof LocalhostProperties)) return false;
		  LocalhostProperties that = (LocalhostProperties) o;
		  return Objects.equals(getUser(), that.getUser());
	 }

	 @Override
	 public int hashCode() {
		  return Objects.hash(getUser());
	 }
}
