package model;

public class User {
    private String email;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public User() {

    }

    public User(final Builder builder) {
        email = builder.email;
        password = builder.password;
    }

    public static final class Builder {
        private String email;
        private String password;


        private Builder() {
        }

        public Builder withEmail(final String val) {
            email = val;
            return this;
        }

        public Builder withPassword(final String val) {
            password = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
