package qa.okay.domain.api.account;

public class UserLoginDetails {
    private String userId;
    private String username;
    private String password;
    private String token;
    private String expires;
    private String created_date;
    public boolean isActive;

    public UserLoginDetails() { }

    public UserLoginDetails(String userId,
                            String username,
                            String password,
                            String token,
                            String expires,
                            String created_date,
                            boolean isActive) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.token = token;
        this.expires = expires;
        this.created_date = created_date;
        this.isActive = isActive;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
