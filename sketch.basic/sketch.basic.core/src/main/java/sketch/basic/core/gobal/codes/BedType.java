package sketch.basic.core.gobal.codes;

import jp.gtf.kernel.lang.define.ICode;

/**
 * ISSUE STATUS
 * @author F
 *
 */
public enum BedType implements ICode {
    SINGLE_TYPE ("0000", "シングルベッド"),
    LOFT_TYPE   ("0001", "ロフトベッド"),
    LV2_TYPE    ("0002", "二段ベッド"),
    ;

    final String code;
    final String description;

    BedType(String code, String description) {
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

    public static BedType getEnum(String code) {
        for(BedType e : BedType.values()) {
            if(e.getCode().equals(code))
                return e;
        }
        return null;
    }

}