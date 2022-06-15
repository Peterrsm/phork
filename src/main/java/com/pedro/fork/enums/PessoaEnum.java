package com.pedro.fork.enums;

import java.util.Arrays;
import java.util.List;

public enum PessoaEnum {
    ANA{
        @Override
        public List<PessoaEnum> knows() {
            return Arrays.asList(PessoaEnum.CARLOS,
                    PessoaEnum.JOAO,
                    PessoaEnum.MARIA,
                    PessoaEnum.VINICIUS);
        }
    },
    MARIA{
        @Override
        public List<PessoaEnum> knows() {
            return Arrays.asList(PessoaEnum.CARLOS,
                    PessoaEnum.ANA,
                    PessoaEnum.VINICIUS);
        }
    },
    VINICIUS{
        @Override
        public List<PessoaEnum> knows() {
            return Arrays.asList(PessoaEnum.CARLOS,
                    PessoaEnum.ANA,
                    PessoaEnum.MARIA);
        }
    },
    LUIZA{
        @Override
        public List<PessoaEnum> knows() {
            return Arrays.asList(PessoaEnum.CARLOS,
                    PessoaEnum.JOAO);
        }
    },
    JOAO{
        @Override
        public List<PessoaEnum> knows() {
            return Arrays.asList(PessoaEnum.CARLOS,
                    PessoaEnum.ANA,
                    PessoaEnum.LUIZA);
        }
    },
    CARLOS{
        @Override
        public List<PessoaEnum> knows() {
            return Arrays.asList(PessoaEnum.CARLOS,
                    PessoaEnum.ANA);
        }
    };

    public abstract List<PessoaEnum> knows();
}
