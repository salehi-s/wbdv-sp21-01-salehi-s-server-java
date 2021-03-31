package com.example.wbdvsp2103salehisserverjava.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "widgets")
public class Widget {

  private String name;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String topicId;
  private String type;
  private Integer widgetOrder;
  private String text;
  private String src;
  private String url;
  private String href;
  private Integer size;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String style;
  private String value;
  private Boolean ordered;

  public Widget(String name,
                Long id,
                String topicId,
                String type,
                Integer widgetOrder,
                String text,
                String src,
                String url,
                String href,
                Integer size,
                Integer width,
                Integer height,
                String cssClass,
                String style,
                String value,
                Boolean ordered) {
    this.name = name;
    this.id = id;
    this.topicId = topicId;
    this.type = type;
    this.widgetOrder = widgetOrder;
    this.text = text;
    this.src = src;
    this.url = url;
    this.href = href;
    this.size = size;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
    this.ordered = ordered;
  }

  public Widget() {
    this.name = "New Widget";
    this.topicId = "6056807cbf36af0017e33f23";
    this.type = "HEADING";
    this.widgetOrder = null;
    this.text = "Widget Text";
    this.src = "https://upload.wikimedia.org/wikipedia/en/b/bd/Northeastern_University_seal.svg";
    this.url = "https://upload.wikimedia.org/wikipedia/en/b/bd/Northeastern_University_seal.svg";
    this.href = "https://upload.wikimedia.org/wikipedia/en/b/bd/Northeastern_University_seal.svg";
    this.size = 1;
    this.width = 100;
    this.height = 100;
    this.cssClass = null;
    this.style = null;
    this.value = "initialValue";
    this.ordered = false;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(Integer widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Boolean getOrdered() {
    return ordered;
  }

  public void setOrdered(Boolean ordered) {
    this.ordered = ordered;
  }
}