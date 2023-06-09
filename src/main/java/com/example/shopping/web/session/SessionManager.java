package com.example.shopping.web.session;

import com.example.shopping.domain.Member.Member;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager<T extends Member> {
    public static final String SESSION_COOKIE_NAME = "mySessionId";
    private Map<String, T> sessionStore = new ConcurrentHashMap<>();

    /**
     * create session
     */

    public void createSession(T value, HttpServletResponse response) {
        //create random value sessionId
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);

        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(cookie);
    }

    /**
     *
     * @param request
     * @return
     */
    public T getSession(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie == null) {
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());
    }

    public void expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie != null) {
            sessionStore.remove(sessionCookie.getValue());
        }
    }

    public Cookie findCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return null;
        }

        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findFirst()
                .orElse(null);

    }
}
