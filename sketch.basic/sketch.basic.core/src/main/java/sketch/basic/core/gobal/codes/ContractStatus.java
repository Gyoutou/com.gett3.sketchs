package sketch.basic.core.gobal.codes;

import jp.gtf.kernel.lang.define.ICode;

/**
 * ISSUE STATUS
 * @author F
 *
 */
public enum ContractStatus implements ICode {
    UNREVIEW ("0000", "審査待ち"),
    NORMAL   ("0001", "正常"),
    REJECTED ("0002", "却下"),
    ;

    final String code;
    final String description;

    ContractStatus(String code, String description) {
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

    public static ContractStatus getEnum(String code) {
        for(ContractStatus e : ContractStatus.values()) {
            if(e.getCode().equals(code))
                return e;
        }
        return null;
    }

}