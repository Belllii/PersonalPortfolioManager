package com.portfolio;

/**
 * Abstract base class for all portfolio entities.
 * Covers Roadmap Stage 21 (Advanced OOP: Abstract class + inheritance).
 */
public abstract class PortfolioEntity implements Displayable {

    protected int id;

    public PortfolioEntity() {
    }

    public PortfolioEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Polymorphic method to get entity type.
     */
    public abstract String getCategoryType();

    @Override
    public String toString() {
        return getDisplayName();
    }
}
