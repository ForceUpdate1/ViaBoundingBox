package de.foorcee.viaboundingbox.api.versions;

import lombok.Setter;

public abstract class WrappedVoxelShapes<V> {
    @Setter
    private static WrappedVoxelShapes instance;

    public WrappedVoxelShapes(){

    }

    public abstract WrappedVoxelShape<V> getEmptyVoxelShapeImpl();
    public abstract WrappedVoxelShape<V> getFullBlockVoxelShapeImpl();
    public abstract WrappedVoxelShape<V> createVoxelShapeImpl(double x1, double y1, double z1, double x2, double y2, double z2);
    public abstract WrappedVoxelShape<V> divideImpl(WrappedVoxelShape<V> voxelShape, double val);

    public static <V> WrappedVoxelShape<V> getEmptyVoxelShape(){
        return instance.getEmptyVoxelShapeImpl();
    }
    public static <V> WrappedVoxelShape<V> getFullBlockVoxelShape(){
        return instance.getFullBlockVoxelShapeImpl();
    }
    public static <V> WrappedVoxelShape<V> createVoxelShape(double x1, double y1, double z1, double x2, double y2, double z2){
        return instance.createVoxelShapeImpl(x1,y1,z1,x2,y2,z2);
    }
    public static <V> WrappedVoxelShape<V> createVoxelShape(double x1, double y1, double z1, double x2, double y2, double z2, double div){
        return instance.createVoxelShapeImpl(x1 / div, y1 / div ,z1 / div,x2 /div,y2 /div ,z2 /div);
    }
    public static <V> WrappedVoxelShape<V> divide(WrappedVoxelShape<V> voxelShape, double val){
        return instance.divideImpl(voxelShape, val);
    }

}
