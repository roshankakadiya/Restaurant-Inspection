package com.example.cmpt276group05.model;

import java.util.List;

public class InspectionEntry {

    /**
     * help : https://data.surrey.ca/api/3/action/help_show?name=package_show
     * success : true
     * result : {"more_information":"","license_title":"Open Government License - City of Surrey","maintainer":"","relationships_as_object":[],"private":false,"maintainer_email":"","num_tags":7,"update_frequency":"Monthly","id":"948e994d-74f5-41a2-b3cb-33fa6a98aa96","metadata_created":"2015-08-14T17:49:37.918776","metadata_modified":"2020-11-06T18:35:30.407705","author":"Fraser Health","author_email":"","state":"active","version":"","creator_user_id":"da50fa72-84ff-4760-93f7-090d47bb1331","type":"dataset","resources":[{"cache_last_updated":null,"package_id":"948e994d-74f5-41a2-b3cb-33fa6a98aa96","datastore_contains_all_records_of_source_file":true,"datastore_active":true,"id":"30b38b66-649f-4507-a632-d5f6f5fe87f1","size":2124904,"original_url":"https://data.surrey.ca/dataset/948e994d-74f5-41a2-b3cb-33fa6a98aa96/resource/30b38b66-649f-4507-a632-d5f6f5fe87f1/download/fraser_health_restaurant_inspection_reports.csv","resource_id":"30b38b66-649f-4507-a632-d5f6f5fe87f1","set_url_type":"False","state":"active","ignore_hash":"False","hash":"fad6da26712711b0fa0e9b09bb50ff9b","description":"Available in CSV format","format":"CSV","mimetype_inner":null,"url_type":"upload","mimetype":"text/csv","cache_url":null,"name":"Fraser Health Restaurant Inspection Reports","created":"2015-08-14T10:50:38.365988","url":"https://data.surrey.ca/dataset/948e994d-74f5-41a2-b3cb-33fa6a98aa96/resource/30b38b66-649f-4507-a632-d5f6f5fe87f1/download/fraser_health_restaurant_inspection_reports.csv","ckan_url":"https://data.surrey.ca","task_created":"2020-11-06 18:35:21.776276","last_modified":"2020-11-06T18:35:19.325380","position":0,"revision_id":"a971cdf8-3499-40ca-927f-de222e3e8c0e","resource_type":null},{"mimetype":null,"cache_url":null,"hash":"","description":"Specification at: http://resources.arcgis.com/en/help/rest/apiref/","name":"Fraser Health Restaurant Inspection Reports","created":"2015-08-14T10:53:26.920761","url":"https://gisservices.surrey.ca/arcgis/rest/services/OpenData/MapServer","datastore_active":false,"format":"API","package_id":"948e994d-74f5-41a2-b3cb-33fa6a98aa96","id":"5ca6b131-a5f9-4dfc-b5da-abad44117be4","cache_last_updated":null,"state":"active","mimetype_inner":null,"last_modified":null,"position":1,"revision_id":"8c145379-2401-4ce2-822b-b16506fa60e3","url_type":"","datastore_contains_all_records_of_source_file":false,"resource_type":null,"size":null}],"num_resources":2,"tags":[{"vocabulary_id":null,"state":"active","display_name":"food","id":"6e6e6956-256f-413e-92c1-c8141a293088","name":"food"},{"vocabulary_id":null,"state":"active","display_name":"fraser","id":"e3840701-a425-4ca0-afb6-69862ba0c96f","name":"fraser"},{"vocabulary_id":null,"state":"active","display_name":"health","id":"7a960e1a-86db-40ed-b230-c3f109f5d1af","name":"health"},{"vocabulary_id":null,"state":"active","display_name":"inspection","id":"0eed0a8f-8c18-44c5-8664-9ef1f5309a0d","name":"inspection"},{"vocabulary_id":null,"state":"active","display_name":"report","id":"e5a57724-a771-40e5-a19c-e095d9addd14","name":"report"},{"vocabulary_id":null,"state":"active","display_name":"restaurant","id":"ea272d4d-43d0-44b1-92bc-926c405661c7","name":"restaurant"},{"vocabulary_id":null,"state":"active","display_name":"safety","id":"bf55b8f2-7acd-4fd4-ac26-360d0f9543e2","name":"safety"}],"attribute_details":"","groups":[{"display_name":"Health and Safety","description":"The City of Surrey is responsible for the encouragement, regulation and enforcement of workplace health, safety and welfare. Residents and families are encouraged to maintain an active and healthy lifestyle and have the ability to attend both registered and drop-in programs. \r\n","image_display_url":"https://data.surrey.ca/uploads/group/20140305-231832.92103420140207163239.525612healthsafety.png","title":"Health and Safety","id":"a129426e-6a90-487d-9e81-52ff0cf5d83d","name":"health-and-safety"}],"license_id":"OGL-Surrey","relationships_as_subject":[],"organization":{"description":"City of Surrey","created":"2014-01-29T15:00:01.396633","title":"City Of Surrey","name":"city-of-surrey","is_organization":true,"state":"active","image_url":"https://www.surrey.ca/images/cos-master/ui/logo.png","revision_id":"ec77b9d7-99b2-40a1-ae80-dec0dc999676","type":"organization","id":"de473b17-6bfa-419f-a058-7d93a2e661b8","approval_status":"approved"},"name":"fraser-health-restaurant-inspection-reports","isopen":true,"coordinate_system":"","url":"","notes":"Inspections are conducted on a routine basis and when complaints are received. Inspections determine if regulatory requirements and industry standard practices are being followed with respect to general food handling, storage temperatures, sanitation, employee hygiene and procedures for cleaning and/or sanitizing equipment or food contact surfaces.\r\n\r\nEach visit generates an inspection report that is provided to the operator to either confirm that they are compliant with regulations, or to inform them that they are required to address deficiencies.\r\n\r\nFor more information please visit the [Fraser Health](http://www.fraserhealth.ca/health-info/health-topics/food-safety/restaurant-inspections/) website.\r\n\r\n*Please note: This dataset will only give you the results of the Fraser Health Inspection Reports. There is a related dataset called [Restaurants](http://data.surrey.ca/dataset/restaurants) that has restaurant information extracted from the Fraser Health Inspection data with the Latitude and Longitude values added by the City of Surrey GIS Section. You can spatially enable this Inspection Reports dataset by joining it to the Restaurants dataset via the \"TrackingNumber\" attribute.","owner_org":"de473b17-6bfa-419f-a058-7d93a2e661b8","is_geospatial":"0","license_url":"/pages/open-government-licence-surrey","title":"Fraser Health Restaurant Inspection Reports","revision_id":"e417e36e-b997-43cd-975c-32f328f90be9","extras":[{"key":"custodian","value":""},{"key":"custodian_email","value":""},{"key":"data_quality","value":""},{"key":"department","value":"City Manager"},{"key":"lineage","value":""},{"key":"metadata_visibility","value":"Public"},{"key":"purpose","value":""},{"key":"view_audience","value":"Public"}]}
     */

    private String help;
    private boolean success;
    private ResultBean result;

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * more_information :
         * license_title : Open Government License - City of Surrey
         * maintainer :
         * relationships_as_object : []
         * private : false
         * maintainer_email :
         * num_tags : 7
         * update_frequency : Monthly
         * id : 948e994d-74f5-41a2-b3cb-33fa6a98aa96
         * metadata_created : 2015-08-14T17:49:37.918776
         * metadata_modified : 2020-11-06T18:35:30.407705
         * author : Fraser Health
         * author_email :
         * state : active
         * version :
         * creator_user_id : da50fa72-84ff-4760-93f7-090d47bb1331
         * type : dataset
         * resources : [{"cache_last_updated":null,"package_id":"948e994d-74f5-41a2-b3cb-33fa6a98aa96","datastore_contains_all_records_of_source_file":true,"datastore_active":true,"id":"30b38b66-649f-4507-a632-d5f6f5fe87f1","size":2124904,"original_url":"https://data.surrey.ca/dataset/948e994d-74f5-41a2-b3cb-33fa6a98aa96/resource/30b38b66-649f-4507-a632-d5f6f5fe87f1/download/fraser_health_restaurant_inspection_reports.csv","resource_id":"30b38b66-649f-4507-a632-d5f6f5fe87f1","set_url_type":"False","state":"active","ignore_hash":"False","hash":"fad6da26712711b0fa0e9b09bb50ff9b","description":"Available in CSV format","format":"CSV","mimetype_inner":null,"url_type":"upload","mimetype":"text/csv","cache_url":null,"name":"Fraser Health Restaurant Inspection Reports","created":"2015-08-14T10:50:38.365988","url":"https://data.surrey.ca/dataset/948e994d-74f5-41a2-b3cb-33fa6a98aa96/resource/30b38b66-649f-4507-a632-d5f6f5fe87f1/download/fraser_health_restaurant_inspection_reports.csv","ckan_url":"https://data.surrey.ca","task_created":"2020-11-06 18:35:21.776276","last_modified":"2020-11-06T18:35:19.325380","position":0,"revision_id":"a971cdf8-3499-40ca-927f-de222e3e8c0e","resource_type":null},{"mimetype":null,"cache_url":null,"hash":"","description":"Specification at: http://resources.arcgis.com/en/help/rest/apiref/","name":"Fraser Health Restaurant Inspection Reports","created":"2015-08-14T10:53:26.920761","url":"https://gisservices.surrey.ca/arcgis/rest/services/OpenData/MapServer","datastore_active":false,"format":"API","package_id":"948e994d-74f5-41a2-b3cb-33fa6a98aa96","id":"5ca6b131-a5f9-4dfc-b5da-abad44117be4","cache_last_updated":null,"state":"active","mimetype_inner":null,"last_modified":null,"position":1,"revision_id":"8c145379-2401-4ce2-822b-b16506fa60e3","url_type":"","datastore_contains_all_records_of_source_file":false,"resource_type":null,"size":null}]
         * num_resources : 2
         * tags : [{"vocabulary_id":null,"state":"active","display_name":"food","id":"6e6e6956-256f-413e-92c1-c8141a293088","name":"food"},{"vocabulary_id":null,"state":"active","display_name":"fraser","id":"e3840701-a425-4ca0-afb6-69862ba0c96f","name":"fraser"},{"vocabulary_id":null,"state":"active","display_name":"health","id":"7a960e1a-86db-40ed-b230-c3f109f5d1af","name":"health"},{"vocabulary_id":null,"state":"active","display_name":"inspection","id":"0eed0a8f-8c18-44c5-8664-9ef1f5309a0d","name":"inspection"},{"vocabulary_id":null,"state":"active","display_name":"report","id":"e5a57724-a771-40e5-a19c-e095d9addd14","name":"report"},{"vocabulary_id":null,"state":"active","display_name":"restaurant","id":"ea272d4d-43d0-44b1-92bc-926c405661c7","name":"restaurant"},{"vocabulary_id":null,"state":"active","display_name":"safety","id":"bf55b8f2-7acd-4fd4-ac26-360d0f9543e2","name":"safety"}]
         * attribute_details :
         * groups : [{"display_name":"Health and Safety","description":"The City of Surrey is responsible for the encouragement, regulation and enforcement of workplace health, safety and welfare. Residents and families are encouraged to maintain an active and healthy lifestyle and have the ability to attend both registered and drop-in programs. \r\n","image_display_url":"https://data.surrey.ca/uploads/group/20140305-231832.92103420140207163239.525612healthsafety.png","title":"Health and Safety","id":"a129426e-6a90-487d-9e81-52ff0cf5d83d","name":"health-and-safety"}]
         * license_id : OGL-Surrey
         * relationships_as_subject : []
         * organization : {"description":"City of Surrey","created":"2014-01-29T15:00:01.396633","title":"City Of Surrey","name":"city-of-surrey","is_organization":true,"state":"active","image_url":"https://www.surrey.ca/images/cos-master/ui/logo.png","revision_id":"ec77b9d7-99b2-40a1-ae80-dec0dc999676","type":"organization","id":"de473b17-6bfa-419f-a058-7d93a2e661b8","approval_status":"approved"}
         * name : fraser-health-restaurant-inspection-reports
         * isopen : true
         * coordinate_system :
         * url :
         * notes : Inspections are conducted on a routine basis and when complaints are received. Inspections determine if regulatory requirements and industry standard practices are being followed with respect to general food handling, storage temperatures, sanitation, employee hygiene and procedures for cleaning and/or sanitizing equipment or food contact surfaces.

         Each visit generates an inspection report that is provided to the operator to either confirm that they are compliant with regulations, or to inform them that they are required to address deficiencies.

         For more information please visit the [Fraser Health](http://www.fraserhealth.ca/health-info/health-topics/food-safety/restaurant-inspections/) website.
         *Please note: This dataset will only give you the results of the Fraser Health Inspection Reports. There is a related dataset called [Restaurants](http://data.surrey.ca/dataset/restaurants) that has restaurant information extracted from the Fraser Health Inspection data with the Latitude and Longitude values added by the City of Surrey GIS Section. You can spatially enable this Inspection Reports dataset by joining it to the Restaurants dataset via the "TrackingNumber" attribute.
         * owner_org : de473b17-6bfa-419f-a058-7d93a2e661b8
         * is_geospatial : 0
         * license_url : /pages/open-government-licence-surrey
         * title : Fraser Health Restaurant Inspection Reports
         * revision_id : e417e36e-b997-43cd-975c-32f328f90be9
         * extras : [{"key":"custodian","value":""},{"key":"custodian_email","value":""},{"key":"data_quality","value":""},{"key":"department","value":"City Manager"},{"key":"lineage","value":""},{"key":"metadata_visibility","value":"Public"},{"key":"purpose","value":""},{"key":"view_audience","value":"Public"}]
         */

        private String more_information;
        private String license_title;
        private String maintainer;
        private String maintainer_email;
        private int num_tags;
        private String update_frequency;
        private String id;
        private String metadata_created;
        private String metadata_modified;
        private String author;
        private String author_email;
        private String state;
        private String version;
        private String creator_user_id;
        private String type;
        private int num_resources;
        private String attribute_details;
        private String license_id;
        private OrganizationBean organization;
        private String name;
        private boolean isopen;
        private String coordinate_system;
        private String url;
        private String notes;
        private String owner_org;
        private String is_geospatial;
        private String license_url;
        private String title;
        private String revision_id;
        private List<?> relationships_as_object;
        private List<ResourcesBean> resources;
        private List<TagsBean> tags;
        private List<GroupsBean> groups;
        private List<?> relationships_as_subject;
        private List<ExtrasBean> extras;

        public String getMore_information() {
            return more_information;
        }

        public void setMore_information(String more_information) {
            this.more_information = more_information;
        }

        public String getLicense_title() {
            return license_title;
        }

        public void setLicense_title(String license_title) {
            this.license_title = license_title;
        }

        public String getMaintainer() {
            return maintainer;
        }

        public void setMaintainer(String maintainer) {
            this.maintainer = maintainer;
        }

        public String getMaintainer_email() {
            return maintainer_email;
        }

        public void setMaintainer_email(String maintainer_email) {
            this.maintainer_email = maintainer_email;
        }

        public int getNum_tags() {
            return num_tags;
        }

        public void setNum_tags(int num_tags) {
            this.num_tags = num_tags;
        }

        public String getUpdate_frequency() {
            return update_frequency;
        }

        public void setUpdate_frequency(String update_frequency) {
            this.update_frequency = update_frequency;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMetadata_created() {
            return metadata_created;
        }

        public void setMetadata_created(String metadata_created) {
            this.metadata_created = metadata_created;
        }

        public String getMetadata_modified() {
            return metadata_modified;
        }

        public void setMetadata_modified(String metadata_modified) {
            this.metadata_modified = metadata_modified;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthor_email() {
            return author_email;
        }

        public void setAuthor_email(String author_email) {
            this.author_email = author_email;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getCreator_user_id() {
            return creator_user_id;
        }

        public void setCreator_user_id(String creator_user_id) {
            this.creator_user_id = creator_user_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getNum_resources() {
            return num_resources;
        }

        public void setNum_resources(int num_resources) {
            this.num_resources = num_resources;
        }

        public String getAttribute_details() {
            return attribute_details;
        }

        public void setAttribute_details(String attribute_details) {
            this.attribute_details = attribute_details;
        }

        public String getLicense_id() {
            return license_id;
        }

        public void setLicense_id(String license_id) {
            this.license_id = license_id;
        }

        public OrganizationBean getOrganization() {
            return organization;
        }

        public void setOrganization(OrganizationBean organization) {
            this.organization = organization;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isIsopen() {
            return isopen;
        }

        public void setIsopen(boolean isopen) {
            this.isopen = isopen;
        }

        public String getCoordinate_system() {
            return coordinate_system;
        }

        public void setCoordinate_system(String coordinate_system) {
            this.coordinate_system = coordinate_system;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getOwner_org() {
            return owner_org;
        }

        public void setOwner_org(String owner_org) {
            this.owner_org = owner_org;
        }

        public String getIs_geospatial() {
            return is_geospatial;
        }

        public void setIs_geospatial(String is_geospatial) {
            this.is_geospatial = is_geospatial;
        }

        public String getLicense_url() {
            return license_url;
        }

        public void setLicense_url(String license_url) {
            this.license_url = license_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRevision_id() {
            return revision_id;
        }

        public void setRevision_id(String revision_id) {
            this.revision_id = revision_id;
        }

        public List<?> getRelationships_as_object() {
            return relationships_as_object;
        }

        public void setRelationships_as_object(List<?> relationships_as_object) {
            this.relationships_as_object = relationships_as_object;
        }

        public List<ResourcesBean> getResources() {
            return resources;
        }

        public void setResources(List<ResourcesBean> resources) {
            this.resources = resources;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<GroupsBean> getGroups() {
            return groups;
        }

        public void setGroups(List<GroupsBean> groups) {
            this.groups = groups;
        }

        public List<?> getRelationships_as_subject() {
            return relationships_as_subject;
        }

        public void setRelationships_as_subject(List<?> relationships_as_subject) {
            this.relationships_as_subject = relationships_as_subject;
        }

        public List<ExtrasBean> getExtras() {
            return extras;
        }

        public void setExtras(List<ExtrasBean> extras) {
            this.extras = extras;
        }

        public static class OrganizationBean {
            /**
             * description : City of Surrey
             * created : 2014-01-29T15:00:01.396633
             * title : City Of Surrey
             * name : city-of-surrey
             * is_organization : true
             * state : active
             * image_url : https://www.surrey.ca/images/cos-master/ui/logo.png
             * revision_id : ec77b9d7-99b2-40a1-ae80-dec0dc999676
             * type : organization
             * id : de473b17-6bfa-419f-a058-7d93a2e661b8
             * approval_status : approved
             */

            private String description;
            private String created;
            private String title;
            private String name;
            private boolean is_organization;
            private String state;
            private String image_url;
            private String revision_id;
            private String type;
            private String id;
            private String approval_status;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isIs_organization() {
                return is_organization;
            }

            public void setIs_organization(boolean is_organization) {
                this.is_organization = is_organization;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getRevision_id() {
                return revision_id;
            }

            public void setRevision_id(String revision_id) {
                this.revision_id = revision_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getApproval_status() {
                return approval_status;
            }

            public void setApproval_status(String approval_status) {
                this.approval_status = approval_status;
            }
        }

        public static class ResourcesBean {
            /**
             * cache_last_updated : null
             * package_id : 948e994d-74f5-41a2-b3cb-33fa6a98aa96
             * datastore_contains_all_records_of_source_file : true
             * datastore_active : true
             * id : 30b38b66-649f-4507-a632-d5f6f5fe87f1
             * size : 2124904
             * original_url : https://data.surrey.ca/dataset/948e994d-74f5-41a2-b3cb-33fa6a98aa96/resource/30b38b66-649f-4507-a632-d5f6f5fe87f1/download/fraser_health_restaurant_inspection_reports.csv
             * resource_id : 30b38b66-649f-4507-a632-d5f6f5fe87f1
             * set_url_type : False
             * state : active
             * ignore_hash : False
             * hash : fad6da26712711b0fa0e9b09bb50ff9b
             * description : Available in CSV format
             * format : CSV
             * mimetype_inner : null
             * url_type : upload
             * mimetype : text/csv
             * cache_url : null
             * name : Fraser Health Restaurant Inspection Reports
             * created : 2015-08-14T10:50:38.365988
             * url : https://data.surrey.ca/dataset/948e994d-74f5-41a2-b3cb-33fa6a98aa96/resource/30b38b66-649f-4507-a632-d5f6f5fe87f1/download/fraser_health_restaurant_inspection_reports.csv
             * ckan_url : https://data.surrey.ca
             * task_created : 2020-11-06 18:35:21.776276
             * last_modified : 2020-11-06T18:35:19.325380
             * position : 0
             * revision_id : a971cdf8-3499-40ca-927f-de222e3e8c0e
             * resource_type : null
             */

            private Object cache_last_updated;
            private String package_id;
            private boolean datastore_contains_all_records_of_source_file;
            private boolean datastore_active;
            private String id;
            private int size;
            private String original_url;
            private String resource_id;
            private String set_url_type;
            private String state;
            private String ignore_hash;
            private String hash;
            private String description;
            private String format;
            private Object mimetype_inner;
            private String url_type;
            private String mimetype;
            private Object cache_url;
            private String name;
            private String created;
            private String url;
            private String ckan_url;
            private String task_created;
            private String last_modified;
            private int position;
            private String revision_id;
            private Object resource_type;

            public Object getCache_last_updated() {
                return cache_last_updated;
            }

            public void setCache_last_updated(Object cache_last_updated) {
                this.cache_last_updated = cache_last_updated;
            }

            public String getPackage_id() {
                return package_id;
            }

            public void setPackage_id(String package_id) {
                this.package_id = package_id;
            }

            public boolean isDatastore_contains_all_records_of_source_file() {
                return datastore_contains_all_records_of_source_file;
            }

            public void setDatastore_contains_all_records_of_source_file(boolean datastore_contains_all_records_of_source_file) {
                this.datastore_contains_all_records_of_source_file = datastore_contains_all_records_of_source_file;
            }

            public boolean isDatastore_active() {
                return datastore_active;
            }

            public void setDatastore_active(boolean datastore_active) {
                this.datastore_active = datastore_active;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getOriginal_url() {
                return original_url;
            }

            public void setOriginal_url(String original_url) {
                this.original_url = original_url;
            }

            public String getResource_id() {
                return resource_id;
            }

            public void setResource_id(String resource_id) {
                this.resource_id = resource_id;
            }

            public String getSet_url_type() {
                return set_url_type;
            }

            public void setSet_url_type(String set_url_type) {
                this.set_url_type = set_url_type;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getIgnore_hash() {
                return ignore_hash;
            }

            public void setIgnore_hash(String ignore_hash) {
                this.ignore_hash = ignore_hash;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getFormat() {
                return format;
            }

            public void setFormat(String format) {
                this.format = format;
            }

            public Object getMimetype_inner() {
                return mimetype_inner;
            }

            public void setMimetype_inner(Object mimetype_inner) {
                this.mimetype_inner = mimetype_inner;
            }

            public String getUrl_type() {
                return url_type;
            }

            public void setUrl_type(String url_type) {
                this.url_type = url_type;
            }

            public String getMimetype() {
                return mimetype;
            }

            public void setMimetype(String mimetype) {
                this.mimetype = mimetype;
            }

            public Object getCache_url() {
                return cache_url;
            }

            public void setCache_url(Object cache_url) {
                this.cache_url = cache_url;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCkan_url() {
                return ckan_url;
            }

            public void setCkan_url(String ckan_url) {
                this.ckan_url = ckan_url;
            }

            public String getTask_created() {
                return task_created;
            }

            public void setTask_created(String task_created) {
                this.task_created = task_created;
            }

            public String getLast_modified() {
                return last_modified;
            }

            public void setLast_modified(String last_modified) {
                this.last_modified = last_modified;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public String getRevision_id() {
                return revision_id;
            }

            public void setRevision_id(String revision_id) {
                this.revision_id = revision_id;
            }

            public Object getResource_type() {
                return resource_type;
            }

            public void setResource_type(Object resource_type) {
                this.resource_type = resource_type;
            }
        }

        public static class TagsBean {
            /**
             * vocabulary_id : null
             * state : active
             * display_name : food
             * id : 6e6e6956-256f-413e-92c1-c8141a293088
             * name : food
             */

            private Object vocabulary_id;
            private String state;
            private String display_name;
            private String id;
            private String name;

            public Object getVocabulary_id() {
                return vocabulary_id;
            }

            public void setVocabulary_id(Object vocabulary_id) {
                this.vocabulary_id = vocabulary_id;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getDisplay_name() {
                return display_name;
            }

            public void setDisplay_name(String display_name) {
                this.display_name = display_name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class GroupsBean {
            /**
             * display_name : Health and Safety
             * description : The City of Surrey is responsible for the encouragement, regulation and enforcement of workplace health, safety and welfare. Residents and families are encouraged to maintain an active and healthy lifestyle and have the ability to attend both registered and drop-in programs.
             * image_display_url : https://data.surrey.ca/uploads/group/20140305-231832.92103420140207163239.525612healthsafety.png
             * title : Health and Safety
             * id : a129426e-6a90-487d-9e81-52ff0cf5d83d
             * name : health-and-safety
             */

            private String display_name;
            private String description;
            private String image_display_url;
            private String title;
            private String id;
            private String name;

            public String getDisplay_name() {
                return display_name;
            }

            public void setDisplay_name(String display_name) {
                this.display_name = display_name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getImage_display_url() {
                return image_display_url;
            }

            public void setImage_display_url(String image_display_url) {
                this.image_display_url = image_display_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ExtrasBean {
            /**
             * key : custodian
             * value :
             */

            private String key;
            private String value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
