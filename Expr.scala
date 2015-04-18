abstract class Expr

case class Var(name: String) extends Expr{
	override def toString = name.toUpperCase();
}//end Var class

case class And(l: Expr, r:Expr) extends Expr{
	override def toString = "(" + l + " and " + r + ")"
}//end and class

case class Or(l: Expr, r:Expr) extends Expr{
	override def toString = "(" + l + " and " + r + ")"
}//end or class

case class Not(l: Expr) extends Expr{
	override def toString = "~(" + l + ")"
}//end Not class
