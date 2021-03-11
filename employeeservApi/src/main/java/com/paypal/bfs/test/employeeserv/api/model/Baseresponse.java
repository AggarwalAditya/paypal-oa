
package com.paypal.bfs.test.employeeserv.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Base Response
 * <p>
 * Base Response Object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "errorCode",
    "message"
})
public class Baseresponse {

    /**
     * errorCode
     * 
     */
    @JsonProperty("errorCode")
    @JsonPropertyDescription("errorCode")
    private Integer errorCode;
    /**
     * message
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("message")
    private Object message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * errorCode
     * 
     */
    @JsonProperty("errorCode")
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * errorCode
     * 
     */
    @JsonProperty("errorCode")
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * message
     * 
     */
    @JsonProperty("message")
    public Object getMessage() {
        return message;
    }

    /**
     * message
     * 
     */
    @JsonProperty("message")
    public void setMessage(Object message) {
        this.message = message;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Baseresponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("errorCode");
        sb.append('=');
        sb.append(((this.errorCode == null)?"<null>":this.errorCode));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
