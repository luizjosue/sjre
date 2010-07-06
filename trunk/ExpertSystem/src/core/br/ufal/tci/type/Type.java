/*
 * Created on 01/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.type;

/**
 * @author ljsf
 *
 * 
 * 
 */
public class Type {

	public static Type cast(Type type1, Type type2){
		if (((type1 instanceof IntegerType) && (type2 instanceof RealType)) || ( (type1 instanceof RealType) && (type2 instanceof IntegerType) )){
			return new RealType();
		}
		if(type1 instanceof IntegerType){
			return new IntegerType();
		}
		if(type1 instanceof RealType){
			return new RealType();
		}
		if(type1 instanceof BooleanType){
			return new BooleanType();
		}
		if(type1 instanceof StringType){
			return new StringType();
		}
		if(type1 instanceof ObjectType){
			return new ObjectType();
		}
		return null;
	}
	
	public static boolean match(Type type1, Type type2){
		if (((type1 instanceof IntegerType) && (type2 instanceof RealType)) || ( (type1 instanceof RealType) && (type2 instanceof IntegerType) )){
			return true;
		}
		if((type1 instanceof IntegerType) && (type2 instanceof IntegerType)){
			return true;
		}
		if( (type1 instanceof RealType) && (type2 instanceof RealType) ){
			return true;
		}
		if( (type1 instanceof BooleanType) && (type2 instanceof BooleanType) ){
			return true;
		}
		if( (type1 instanceof StringType) && (type2 instanceof StringType) ){
			return true;
		}
		if( (type1 instanceof ObjectType) && (type2 instanceof ObjectType) ){
			return true;
		}
		return false;
	}
	
}
