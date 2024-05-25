package com.mphasis.task.pages.dto;

public class WellsFargoLocationDto {

    private String locationName;

    private String city;

    private String state;

    private String address;

    private String phone;

    private String locationLongitude;

    private String locationLatitude;

    WellsFargoLocationDto(String locationName, String city, String state, String address, String phone, String locationLongitude, String locationLatitude) {
        this.locationName = locationName;
        this.city = city;
        this.state = state;
        this.address = address;
        this.phone = phone;
        this.locationLongitude = locationLongitude;
        this.locationLatitude = locationLatitude;
    }

    public static WellsFargoLocationDtoBuilder builder() {
        return new WellsFargoLocationDtoBuilder();
    }

    public String getLocationName() {
        return this.locationName;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getLocationLongitude() {
        return this.locationLongitude;
    }

    public String getLocationLatitude() {
        return this.locationLatitude;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof WellsFargoLocationDto)) return false;
        final WellsFargoLocationDto other = (WellsFargoLocationDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$locationName = this.getLocationName();
        final Object other$locationName = other.getLocationName();
        if (this$locationName == null ? other$locationName != null : !this$locationName.equals(other$locationName))
            return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$locationLongitude = this.getLocationLongitude();
        final Object other$locationLongitude = other.getLocationLongitude();
        if (this$locationLongitude == null ? other$locationLongitude != null : !this$locationLongitude.equals(other$locationLongitude))
            return false;
        final Object this$locationLatitude = this.getLocationLatitude();
        final Object other$locationLatitude = other.getLocationLatitude();
        if (this$locationLatitude == null ? other$locationLatitude != null : !this$locationLatitude.equals(other$locationLatitude))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof WellsFargoLocationDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $locationName = this.getLocationName();
        result = result * PRIME + ($locationName == null ? 43 : $locationName.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $state = this.getState();
        result = result * PRIME + ($state == null ? 43 : $state.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $locationLongitude = this.getLocationLongitude();
        result = result * PRIME + ($locationLongitude == null ? 43 : $locationLongitude.hashCode());
        final Object $locationLatitude = this.getLocationLatitude();
        result = result * PRIME + ($locationLatitude == null ? 43 : $locationLatitude.hashCode());
        return result;
    }

    public String toString() {
        return "WellsFargoLocationDto(locationName=" + this.getLocationName() + ", city=" + this.getCity() + ", state=" + this.getState() + ", address=" + this.getAddress() + ", phone=" + this.getPhone() + ", locationLongitude=" + this.getLocationLongitude() + ", locationLatitude=" + this.getLocationLatitude() + ")";
    }

    public static class WellsFargoLocationDtoBuilder {
        private String locationName;
        private String city;
        private String state;
        private String address;
        private String phone;
        private String locationLongitude;
        private String locationLatitude;

        WellsFargoLocationDtoBuilder() {
        }

        public WellsFargoLocationDtoBuilder locationName(String locationName) {
            this.locationName = locationName;
            return this;
        }

        public WellsFargoLocationDtoBuilder city(String city) {
            this.city = city;
            return this;
        }

        public WellsFargoLocationDtoBuilder state(String state) {
            this.state = state;
            return this;
        }

        public WellsFargoLocationDtoBuilder address(String address) {
            this.address = address;
            return this;
        }

        public WellsFargoLocationDtoBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public WellsFargoLocationDtoBuilder locationLongitude(String locationLongitude) {
            this.locationLongitude = locationLongitude;
            return this;
        }

        public WellsFargoLocationDtoBuilder locationLatitude(String locationLatitude) {
            this.locationLatitude = locationLatitude;
            return this;
        }

        public WellsFargoLocationDto build() {
            return new WellsFargoLocationDto(this.locationName, this.city, this.state, this.address, this.phone, this.locationLongitude, this.locationLatitude);
        }

        public String toString() {
            return "WellsFargoLocationDto.WellsFargoLocationDtoBuilder(locationName=" + this.locationName + ", city=" + this.city + ", state=" + this.state + ", address=" + this.address + ", phone=" + this.phone + ", locationLongitude=" + this.locationLongitude + ", locationLatitude=" + this.locationLatitude + ")";
        }
    }
}

