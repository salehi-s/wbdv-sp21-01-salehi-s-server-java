package com.example.wbdvsp2103salehisserverjava.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.example.wbdvsp2103salehisserverjava.models.Widget;
import com.example.wbdvsp2103salehisserverjava.repositories.WidgetRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

  public Widget createWidget(String tid, Widget widget) {
    /*
    Long id = (new Date()).getTime();
    widget.setId(id);
    widgets.add(widget);
    return widget;
    */

    return repository.save(widget);
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    /*
    List<Widget> ws = new ArrayList<Widget>();
    for (Widget w : widgets) {
      if (w.getTopicId().equals(tid)) {
        ws.add(w);
      }
    }
    return ws;
    */

    return repository.findWidgetsForTopic(tid);
  }

  public int updateWidget(Long wid, Widget widget) {
    /*
    for (int i = 0 ; i < widgets.size() ; i++) {
      Widget w = widgets.get(i);
      if (w.getId().equals(wid)) {
        widgets.set(i, widget);
        return 1;
      }
    }
    return 0;
    */

    Widget originalWidget = findWidgetById(wid);

    if (widget.getName() != null) {
      originalWidget.setName(widget.getName());
    }
    if (widget.getId() != null) {
      originalWidget.setId(widget.getId());
    }
    if (widget.getTopicId() != null) {
      originalWidget.setTopicId(widget.getTopicId());
    }
    if (widget.getType() != null) {
      originalWidget.setType(widget.getType());
    }
    if (widget.getWidgetOrder() != null) {
      originalWidget.setWidgetOrder(widget.getWidgetOrder());
    }
    if (widget.getText() != null) {
      originalWidget.setText(widget.getText());
    }
    if (widget.getSrc() != null) {
      originalWidget.setSrc(widget.getSrc());
    }
    if (widget.getUrl() != null) {
      originalWidget.setUrl(widget.getUrl());
    }
    if (widget.getHref() != null) {
      originalWidget.setHref(widget.getHref());
    }
    if (widget.getSize() != null) {
      originalWidget.setSize(widget.getSize());
    }
    if (widget.getWidth() != null) {
      originalWidget.setWidth(widget.getWidth());
    }
    if (widget.getHeight() != null) {
      originalWidget.setHeight(widget.getHeight());
    }
    if (widget.getCssClass() != null) {
      originalWidget.setCssClass(widget.getCssClass());
    }
    if (widget.getStyle() != null) {
      originalWidget.setStyle(widget.getStyle());
    }
    if (widget.getValue() != null) {
      originalWidget.setValue(widget.getValue());
    }
    if (widget.getOrdered() != null) {
      originalWidget.setOrdered(widget.getOrdered());
    }

    repository.save(originalWidget);
    return 1;
  }

  public int deleteWidget(Long wid) {
    /*
    int index = -1;
    for (int i = 0; i < widgets.size(); i++) {
      Widget w = widgets.get(i);
      if (w.getId().equals(wid)) {
        index = i;
      }
    }
    if (index >= 0) {
      widgets.remove(index);
      return 1;
    }
    return 0;
    */

    repository.deleteById(wid);
    return 1;
  }

  public List<Widget> findAllWidgets() {
    /*
    return widgets;
    */
    // return (List<Widget>)repository.findAll();

    return repository.findAllWidgets();
  }

  public Widget findWidgetById(Long wid) {
    /*
    for (Widget w : widgets) {
      if (w.getId().equals(wid)) {
        return w;
      }
    }
    return null;
    */
    // return repository.findById(wid).get();

    return repository.findWidgetById(wid);
  }
}