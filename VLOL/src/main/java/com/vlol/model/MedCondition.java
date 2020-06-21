/**
 * Medical Condition Class.
 *
 * Java Runtime Environment (JRE) version used: 11.0.7
 * Java Development Kit (JDK) version used: 11.0.7
 *
 * Styling guide: Google Java Style Guide
 *     (https://google.github.io/styleguide/javaguide.html) and
 *     Code Conventions for the Java Programming Language (Oracle: Deprecated)
 *     (https://www.oracle.com/technetwork/java/javase/documentation/codeconvtoc-136057.html)
 *
 * @category  vlol
 * @package model
 * @author Rob Garcia <rgarcia92@student.umgc.edu>
 * @license https://opensource.org/licenses/MIT The MIT License
 * @link      https://github.com/garciart/SWEN670
 * @copyright 2020 EMS Plus
 */
package com.vlol.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "med_condition")
public class MedCondition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condition_id")
    private Long conditionID;

    @Column(name = "condition_name", unique = true)
    @NotBlank(message = "Condition name is required.")
    private String conditionName;

    @ManyToMany(mappedBy = "conditions", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<User> users;

    public Long getConditionID() {
        return conditionID;
    }

    public void setConditionID(Long conditionID) {
        this.conditionID = conditionID;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
