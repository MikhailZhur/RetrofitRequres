package models;

public class SingleUserResponse {
    public UserResponse data;
    public Support support;
    public Meta _meta;

    public SingleUserResponse(UserResponse data, Support support, Meta _meta) {
        this.data = data;
        this.support = support;
        this._meta = _meta;
    }

    public UserResponse getData() {
        return data;
    }

    public void setData(UserResponse data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public Meta get_meta() {
        return _meta;
    }

    public void set_meta(Meta _meta) {
        this._meta = _meta;
    }
}
