package de.nick2202.cooplist.backend.dto;

import de.nick2202.cooplist.backend.model.ItemList;
import java.util.List;
import javax.annotation.processing.Generated;
import net.karneim.pojobuilder.GwtIncompatible;

@Generated("PojoBuilder")
public class UserDtoBuilder
    implements Cloneable {
  protected UserDtoBuilder self;
  protected Long value$id$java$lang$Long;
  protected boolean isSet$id$java$lang$Long;
  protected String value$firstName$java$lang$String;
  protected boolean isSet$firstName$java$lang$String;
  protected String value$lastName$java$lang$String;
  protected boolean isSet$lastName$java$lang$String;
  protected String value$userName$java$lang$String;
  protected boolean isSet$userName$java$lang$String;
  protected String value$email$java$lang$String;
  protected boolean isSet$email$java$lang$String;
  protected String value$password$java$lang$String;
  protected boolean isSet$password$java$lang$String;
  protected Boolean value$isAdmin$java$lang$Boolean;
  protected boolean isSet$isAdmin$java$lang$Boolean;
  protected List<ItemList> value$itemLists$java$util$List;
  protected boolean isSet$itemLists$java$util$List;

  /**
   * Creates a new {@link UserDtoBuilder}.
   */
  public UserDtoBuilder() {
    self = (UserDtoBuilder)this;
  }

  /**
   * Sets the default value for the id property.
   *
   * @param value the default value
   * @return this builder
   */
  public UserDtoBuilder withId(Long value) {
    this.value$id$java$lang$Long = value;
    this.isSet$id$java$lang$Long = true;
    return self;
  }

  /**
   * Sets the default value for the firstName property.
   *
   * @param value the default value
   * @return this builder
   */
  public UserDtoBuilder withFirstName(String value) {
    this.value$firstName$java$lang$String = value;
    this.isSet$firstName$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the lastName property.
   *
   * @param value the default value
   * @return this builder
   */
  public UserDtoBuilder withLastName(String value) {
    this.value$lastName$java$lang$String = value;
    this.isSet$lastName$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the userName property.
   *
   * @param value the default value
   * @return this builder
   */
  public UserDtoBuilder withUserName(String value) {
    this.value$userName$java$lang$String = value;
    this.isSet$userName$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the email property.
   *
   * @param value the default value
   * @return this builder
   */
  public UserDtoBuilder withEmail(String value) {
    this.value$email$java$lang$String = value;
    this.isSet$email$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the password property.
   *
   * @param value the default value
   * @return this builder
   */
  public UserDtoBuilder withPassword(String value) {
    this.value$password$java$lang$String = value;
    this.isSet$password$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the isAdmin property.
   *
   * @param value the default value
   * @return this builder
   */
  public UserDtoBuilder withIsAdmin(Boolean value) {
    this.value$isAdmin$java$lang$Boolean = value;
    this.isSet$isAdmin$java$lang$Boolean = true;
    return self;
  }

  /**
   * Sets the default value for the itemLists property.
   *
   * @param value the default value
   * @return this builder
   */
  public UserDtoBuilder withItemLists(List<ItemList> value) {
    this.value$itemLists$java$util$List = value;
    this.isSet$itemLists$java$util$List = true;
    return self;
  }

  /**
   * Returns a clone of this builder.
   *
   * @return the clone
   */
  @Override
  @GwtIncompatible
  public Object clone() {
    try {
      UserDtoBuilder result = (UserDtoBuilder)super.clone();
      result.self = result;
      return result;
    } catch (CloneNotSupportedException e) {
      throw new InternalError(e.getMessage());
    }
  }

  /**
   * Returns a clone of this builder.
   *
   * @return the clone
   */
  @GwtIncompatible
  public UserDtoBuilder but() {
    return (UserDtoBuilder)clone();
  }

  /**
   * Creates a new {@link UserDto} based on this builder's settings.
   *
   * @return the created UserDto
   */
  public UserDto build() {
    try {
      UserDto result = new UserDto();
      if (isSet$id$java$lang$Long) {
        result.setId(value$id$java$lang$Long);
      }
      if (isSet$firstName$java$lang$String) {
        result.setFirstName(value$firstName$java$lang$String);
      }
      if (isSet$lastName$java$lang$String) {
        result.setLastName(value$lastName$java$lang$String);
      }
      if (isSet$userName$java$lang$String) {
        result.setUserName(value$userName$java$lang$String);
      }
      if (isSet$email$java$lang$String) {
        result.setEmail(value$email$java$lang$String);
      }
      if (isSet$password$java$lang$String) {
        result.setPassword(value$password$java$lang$String);
      }
      if (isSet$isAdmin$java$lang$Boolean) {
        result.setIsAdmin(value$isAdmin$java$lang$Boolean);
      }
      if (isSet$itemLists$java$util$List) {
        result.setItemLists(value$itemLists$java$util$List);
      }
      return result;
    } catch (RuntimeException ex) {
      throw ex;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
