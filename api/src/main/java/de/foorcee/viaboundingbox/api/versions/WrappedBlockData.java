package de.foorcee.viaboundingbox.api.versions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
@EqualsAndHashCode(of = "blockData")
public abstract class WrappedBlockData<D,B> {
    @Getter
    private final D blockData;

    public abstract boolean isEquals(D data);
    public abstract boolean isBlock(B block);
    public boolean apply(Function<D, Boolean> function){
        return function.apply(blockData);
    }
    public boolean isBlock(B... blocks){
        for (B block : blocks) {
            if(isBlock(block)){
                return true;
            }
        }
        return false;
    }
}
