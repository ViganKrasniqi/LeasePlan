package utility;

import lombok.Data;

@Data
public class Detail {
    private String served_by;
    private boolean error;
    private String message;
    private String requested_item;

    public static boolean validateProperErrorStructure(Detail detail, String missing_product) {
        return detail.getMessage().equals("Not found") &&
                detail.getRequested_item().equals(missing_product) &&
                detail.getServed_by().equals("https://waarkoop.com") &&
                detail.isError();
    }
}
