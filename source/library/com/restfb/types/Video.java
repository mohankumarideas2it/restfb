/*
 * Copyright (c) 2010-2014 Mark Allen.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.restfb.types;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.restfb.Facebook;
import com.restfb.JsonMapper.JsonMappingCompleted;
import static com.restfb.util.DateUtils.toDateFromLongFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the <a href="http://developers.facebook.com/docs/reference/api/video">Video Graph API type</a>.
 * 
 * @author <a href="http://restfb.com">Mark Allen</a>
 * @since 1.5
 */
public class Video extends NamedFacebookType {

  /**
   * An object containing the name and ID of the user who posted the video.
   * 
   * @return An object containing the name and ID of the user who posted the video.
   */
  @Getter
  @Setter
  @Facebook
  private CategorizedFacebookType from;

  /**
   * The video title / caption.
   * 
   * @return The video title / caption.
   * @deprecated FB seems to have removed this field.
   */
  @Getter
  @Setter
  @Facebook
  @Deprecated
  private String message;

  /**
   * The long-form HTML description of the video.
   * 
   * @return The long-form HTML description of the video.
   */
  @Getter
  @Setter
  @Facebook
  private String description;

  /**
   * A picture URL which represents the video.
   * 
   * @return A picture URL which represents the video.
   */
  @Getter
  @Setter
  @Facebook
  private String picture;

  /**
   * An icon URL which represents the video.
   * 
   * @return An icon URL which represents the video.
   */
  @Getter
  @Setter
  @Facebook
  private String icon;

  /**
   * A URL to the raw, playable video file.
   * 
   * @return A URL to the raw, playable video file.
   * @since 1.6.5
   */
  @Getter
  @Setter
  @Facebook
  private String source;

  /**
   * HTML that may be used to embed the video on another website.
   * 
   * @return HTML that may be used to embed the video on another website.
   */
  @Getter
  @Setter
  @Facebook("embed_html")
  private String embedHtml;

  /**
   * The length of the video, in seconds.
   * 
   * @return The length of the video, in seconds.
   */
  @Getter
  @Setter
  @Facebook
  private Integer length;

  @Facebook("created_time")
  private String rawCreatedTime;

  @Facebook("updated_time")
  private String rawUpdatedTime;

  /**
   * The time the video was initially published.
   * 
   * @return The time the video was initially published.
   */
  @Getter
  @Setter
  private Date createdTime;

  /**
   * The last time the video or its caption were updated.
   * 
   * @return The last time the video or its caption were updated.
   */
  @Getter
  @Setter
  private Date updatedTime;

  @Facebook
  private List<NamedFacebookType> tags = new ArrayList<NamedFacebookType>();

  @Facebook
  private List<Comment> comments = new ArrayList<Comment>();

  private static final long serialVersionUID = 1L;

  /**
   * Tags for the video.
   * 
   * @return Tags for the video.
   * @since 1.6.5
   */
  public List<NamedFacebookType> getTags() {
    return unmodifiableList(tags);
  }

  public boolean addTag(NamedFacebookType tag) {
    return tags.add(tag);
  }

  public boolean removeTag(NamedFacebookType tag) {
    return tags.remove(tag);
  }

  /**
   * Comments for the video.
   * 
   * @return Comments for the video.
   */
  public List<Comment> getComments() {
    return unmodifiableList(comments);
  }

  public boolean addComment(Comment comment) {
    return comments.add(comment);
  }

  public boolean removeComment(Comment comment) {
    return comments.remove(comment);
  }

  @JsonMappingCompleted
  void convertTime() {
    createdTime = toDateFromLongFormat(rawCreatedTime);
    updatedTime = toDateFromLongFormat(rawUpdatedTime);
  }
}