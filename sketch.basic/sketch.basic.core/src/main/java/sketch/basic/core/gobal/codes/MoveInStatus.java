package sketch.basic.core.gobal.codes;

import jp.gtf.kernel.lang.define.ICode;

/**
 * ISSUE STATUS
 * @author F
 *
 */
public enum MoveInStatus implements ICode {
    EMPTY       ("0000", "空室"),
    EMPTY_PLANS ("0001", "空室予定"),
    LIVING      ("0002", "入居中"),
    ;

    final String code;
    final String description;

    MoveInStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static MoveInStatus getEnum(String code) {
        for(MoveInStatus e : MoveInStatus.values()) {
            if(e.getCode().equals(code))
                return e;
        }
        return MoveInStatus.EMPTY;
    }

}