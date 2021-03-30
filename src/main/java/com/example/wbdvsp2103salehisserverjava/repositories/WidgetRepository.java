package com.example.wbdvsp2103salehisserverjava.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.wbdvsp2103salehisserverjava.models.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Long> {

  @Query(value = "SELECT * FROM widgets WHERE topic_id = :tid",
         nativeQuery = true)
  public List<Widget> findWidgetsForTopic(@Param("tid") String topicId);

  @Query(value = "SELECT * FROM widgets",
         nativeQuery = true)
  public List<Widget> findAllWidgets();

  @Query(value = "SELECT * FROM widgets WHERE id = :wid",
          nativeQuery = true)
  public Widget findWidgetById(@Param("wid") Long widgetId);
}