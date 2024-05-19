package com.itia.sitevitrine.setup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.itia.sitevitrine.configs.security.JwtService;
import com.itia.sitevitrine.repository.TokenRespository;
import com.itia.sitevitrine.utils.TestsUtils;

@WithMockUser()
@MockBean(JpaMetamodelMappingContext.class)
public abstract class AbstractUnitTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private TokenRespository tokenRespository;

    protected MockMvc mockMvc;

    private String jwtToken;

    @BeforeEach()
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected <T> ResponseEntity<T> doPost(String path, Object request, Class<T> responseType, Object... uriVariables)
            throws Exception {
        String jsonRequest = TestsUtils.asJsonString(request);

        MockHttpServletRequestBuilder requestBuilder = post(path, uriVariables)
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON);

        if (jwtToken != null && !jwtToken.isBlank()) {
            requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        }

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        HttpHeaders headers = new HttpHeaders();
        response.getHeaderNames().forEach(headerName -> headers.addAll(headerName, response.getHeaders(headerName)));

        return ResponseEntity.status(response.getStatus())
                .headers(headers)
                .body(TestsUtils.fromJsonString(response.getContentAsString(), responseType));
    }

    protected <T> ResponseEntity<T> doPost(String path, Object request, ParameterizedTypeReference<T> responseType,
            Object... uriVariables)
            throws Exception {
        String jsonRequest = TestsUtils.asJsonString(request);

        MockHttpServletRequestBuilder requestBuilder = post(path, uriVariables)
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON);

        if (jwtToken != null && !jwtToken.isBlank()) {
            requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        }

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        HttpHeaders headers = new HttpHeaders();
        response.getHeaderNames().forEach(headerName -> headers.addAll(headerName, response.getHeaders(headerName)));

        return ResponseEntity.status(response.getStatus())
                .headers(headers)
                .body(TestsUtils.fromJsonString(response.getContentAsString(), responseType));
    }

    protected <T> ResponseEntity<T> doPost(String path, Object request, TypeReference<T> responseType,
            Object... uriVariables)
            throws Exception {
        String jsonRequest = TestsUtils.asJsonString(request);

        MockHttpServletRequestBuilder requestBuilder = post(path, uriVariables)
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON);

        if (jwtToken != null && !jwtToken.isBlank()) {
            requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        }

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        HttpHeaders headers = new HttpHeaders();
        response.getHeaderNames().forEach(headerName -> headers.addAll(headerName, response.getHeaders(headerName)));

        return ResponseEntity.status(response.getStatus())
                .headers(headers)
                .body(TestsUtils.fromJsonString(response.getContentAsString(), responseType));
    }

    protected <T> ResponseEntity<T> doPut(String path, Object request, Class<T> responseType, Object... uriVariables)
            throws Exception {
        String jsonRequest = TestsUtils.asJsonString(request);

        MockHttpServletRequestBuilder requestBuilder = put(path, uriVariables)
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON);

        if (jwtToken != null && !jwtToken.isBlank()) {
            requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        }

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        HttpHeaders headers = new HttpHeaders();
        response.getHeaderNames().forEach(headerName -> headers.addAll(headerName, response.getHeaders(headerName)));

        return ResponseEntity.status(response.getStatus())
                .headers(headers)
                .body(TestsUtils.fromJsonString(response.getContentAsString(), responseType));
    }

    protected <T> ResponseEntity<T> doPut(String path, Object request, ParameterizedTypeReference<T> responseType,
            Object... uriVariables)
            throws Exception {
        String jsonRequest = TestsUtils.asJsonString(request);

        MockHttpServletRequestBuilder requestBuilder = put(path, uriVariables)
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON);

        if (jwtToken != null && !jwtToken.isBlank()) {
            requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        }

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        HttpHeaders headers = new HttpHeaders();
        response.getHeaderNames().forEach(headerName -> headers.addAll(headerName, response.getHeaders(headerName)));

        return ResponseEntity.status(response.getStatus())
                .headers(headers)
                .body(TestsUtils.fromJsonString(response.getContentAsString(), responseType));
    }

    protected <T> ResponseEntity<T> doGet(String path, Class<T> responseType, Object... uriVariables) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get(path, uriVariables);

        if (jwtToken != null && !jwtToken.isBlank()) {
            requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        }

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        HttpHeaders headers = new HttpHeaders();
        response.getHeaderNames().forEach(headerName -> headers.addAll(headerName, response.getHeaders(headerName)));

        return ResponseEntity.status(response.getStatus())
                .headers(headers)
                .body(TestsUtils.fromJsonString(response.getContentAsString(), responseType));
    }

    protected <T> ResponseEntity<T> doGet(String path, ParameterizedTypeReference<T> responseType,
            Object... uriVariables) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get(path, uriVariables);

        if (jwtToken != null && !jwtToken.isBlank()) {
            requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        }

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        HttpHeaders headers = new HttpHeaders();
        response.getHeaderNames().forEach(headerName -> headers.addAll(headerName, response.getHeaders(headerName)));

        return ResponseEntity.status(response.getStatus())
                .headers(headers)
                .body(TestsUtils.fromJsonString(response.getContentAsString(), responseType));
    }

    protected <T> ResponseEntity<T> doDelete(String path, Class<T> responseType, Object... uriVariables)
            throws Exception {
        MockHttpServletRequestBuilder requestBuilder = delete(path, uriVariables);

        if (jwtToken != null && !jwtToken.isBlank()) {
            requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        }

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        HttpHeaders headers = new HttpHeaders();
        response.getHeaderNames().forEach(headerName -> headers.addAll(headerName, response.getHeaders(headerName)));

        return ResponseEntity.status(response.getStatus()).headers(headers)
                .body(TestsUtils.fromJsonString(response.getContentAsString(), responseType));
    }

    protected <T> ResponseEntity<T> doDelete(String path, ParameterizedTypeReference<T> responseType,
            Object... uriVariables) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = delete(path, uriVariables);

        if (jwtToken != null && !jwtToken.isBlank()) {
            requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        }

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        HttpHeaders headers = new HttpHeaders();
        response.getHeaderNames().forEach(headerName -> headers.addAll(headerName, response.getHeaders(headerName)));

        return ResponseEntity.status(response.getStatus()).headers(headers)
                .body(TestsUtils.fromJsonString(response.getContentAsString(), responseType));
    }
}
