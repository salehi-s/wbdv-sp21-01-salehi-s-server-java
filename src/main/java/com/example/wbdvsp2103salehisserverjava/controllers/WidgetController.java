package com.example.wbdvsp2103salehisserverjava.controllers;

import com.example.wbdvsp2103salehisserverjava.models.Widget;

import java.util.List;
import java.util.ArrayList;

public class WidgetController {
  public Widget createWidget(String tid, Widget widget) {
    return new Widget();
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    return new ArrayList<Widget>();
  }

  public int updateWidget(String wid, Widget widget) {
    return -1;
  }

  public int deleteWidget(String wid) {
    return -1;
  }
}