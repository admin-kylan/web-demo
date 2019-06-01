package com.cloud.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * className AsinEntity
 * by Kylan
 *
 * @author Kylan
 * @date 2019-04-14 17:50
 */
@Entity
@Table(name="asin")
public class AsinEntity implements Serializable {

    @Id
    private String asinId;

    @Column(length=1000)
    private String url;

    /**
     * 属于那一种类别
     */
    @Column
    private String type;

    @Column
    private String searchName;

    @Column
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getAsinId() {
        return asinId;
    }

    public void setAsinId(String asinId) {
        this.asinId = asinId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
