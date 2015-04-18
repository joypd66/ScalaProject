import java.util.Scanner;

object Main{
	var A = Var("A")
	var B = Var("B")
	var C = Var("C")
	var D = Var("D")
	var E = Var("E")

	var X = Var("X")
	var Y = Var("Y")
	var Z = Var("Z")
	var True = Var("true")
	var False = Var("false")
	var inX = "init"
	var inY = "init"
	var inZ = "init"
	
	//DEBUGGING:
	//println(inX)
	
	//DEBUGGING:
	while(inX != "true" && inX != "false" && inX != "none" && inX != "" && inX != "0" && inX != "null" && inX != "nil" && inX != "1"){
		println("Input X binding (true, false, or none): ")
		val scan = new Scanner(System.in)
		inX = scan.nextLine().toLowerCase().trim()
		
		if(inX == "true" || inX == "1"){
			X = Var("true")
		}//end if statement

		else if(inX == "false" || inX == "nil" || inX == "null" || inX == "0"){
			X = Var("false")
		}//end else if statement

		else if(inX != "none" && inX != ""){
			println()
			println("Incorrect input. Please try again.")
		}//end else statement
	}//end while loop
	
	//
	while(inY != "true" && inY != "false" && inY != "none" && inY != "" && inY != "0" && inY != "null" && inY != "nil" && inY != "1"){
		println("Input Y binding (true, false, or none): ")
		val scan = new Scanner(System.in)
		inY = scan.nextLine().toLowerCase().trim()
		
		if(inY == "true" || inY == "1"){
			Y = Var("true")
		}//end if statement

		else if(inY == "false" || inY == "nil" || inY == "null" || inY == "0"){
			Y = Var("false")
		}//end else if statement

		else if(inY != "none" && inY != ""){
			println()
			println("Incorrect input. Please try again.")
		}//end else statement
	}//end while loop

	while(inZ != "true" && inZ != "false" && inZ != "none" && inZ != "" && inZ != "0" && inZ != "null" && inZ != "nil" && inZ != "1"){
		println("Input Z binding (true, false, or none): ")
		val scan = new Scanner(System.in)
		inZ = scan.nextLine().toLowerCase().trim()
		
		if(inZ == "true" || inZ == "1"){
			Z = Var("true")
		}//end if statement

		else if(inZ == "false" || inZ == "nil" || inZ == "null" || inZ == "0"){
			Z = Var("false")
		}//end else if statement

		else if(inZ != "none" && inZ != ""){
			println()
			println("Incorrect input. Please try again.")
		}//end else statement
	}//end while loop

	
	def main(args: Array[String]){		
		println("Not(True) == \nVar(false):")
		println(simplify(Not(True)))
	
		println()
		println("Not(Not(True)) == \nVar(true):")
		println(simplify(Not(Not(True))))

		println()
		println("Not(Not(Not(True))) == \nVar(false):")
		println(simplify(Not(Not(Not(True)))))

		println()
		println("Not(X) == \nNot(Var(X)):")
		println(simplify(Not(X)))
		
		println()
		println("Not(Var(\"X\")) = \nNot(Var(X)):")
		println(simplify(Not(X)))
		
		println()
		println("Not(And(X,Y)) == \nOr(Not(Var(X)),Not(Var(Y))):")
		println(simplify(Not(And(X,Y))))

		println()
		println("Not(Or(X,Y)) == \nAnd(Not(Var(X)),Not(Var(Y))):")
		println(simplify(Not(Or(X,Y))))

		println()
		println("Not(Or(Not(X),Y) == \nAnd(Var(X),Not(Var(Y))):")
		println(simplify(Not(Or(Not(X),Y))))

		println()
		println("Not(Or(Not(Or(Not(X),Y)),(Not(Or(Not(X),Y))))) == ")
		println("Or(Not(Var(X)),Var(Y)):")
		println(simplify(Not(Or(Not(Or(Not(X),Y)),(Not(Or(Not(X),Y)))))))

		println()
		println("Or(X, Y) == \nOr(Var(X),Var(Y)):")
		println(simplify(Or(X,Y)))
		
		println()
		println("Or(Not(Not(X)),Not(Y)) == \nOr(Var(X),Not(Var(Y))):")
		println(simplify(Or(Not(Not(X)),Not(Y))))
		
		println()
		println("Or(Or(X,Y), Or(X,Z)) == \nOr(Or(Var(X),Var(Y)),Or(Var(X),Var(Z))):")	
		println(simplify(Or((Or(X, Y)),(Or(X,Z)))))

		println()
		println("Or(X, And(Y,Z)) == \nAnd(Or(Var(X),Var(Y)),Or(Var(X),Var(Z))):")
		println(simplify(Or(X, And(Y, Z))))
		
		println()
		println("And(X, Y) == \nAnd(Var(X),Var(Y)):")
		println(simplify(And(X, Y)))
		
		println()
		println("And(Not(Not(X)),Not(Y)) == \nAnd(Var(X),Not(Var(Y))):")
		println(simplify(And(Not(Not(X)),Not(Y))))

		println()
		println("And(And(X,Y), And(X,Z)) == \nAnd(And(Var(X),Var(Y)),And(Var(X),Var(Z))):")	
		println(simplify(And((And(X, Y)),(And(X,Z)))))
		
		println()
		println("And(X, Or(Y, Z)) == \nOr(And(Var(X),Var(Y)),And(Var(X),Var(Z))):")
		println(simplify(And(X, Or(Y, Z))))

		println()
		println("********************* P Tests *********************")
		println("*********NEEDS SOMETHING MORE*********")
		println("P1: (and x (or x (and y (not z)))) == X:")
		println("P1: And(Var(X),Or(Var(X),And(Var(Y),Not(Var(Z)))))) == \nX:")
		println(simplify(And(X,Or(X,And(Y,Not(Z))))))
		
		println()	
		println("P2: (and (and z nil) (or x 1)):")
		println("P2: And(And(Var(Z),False),Or(Var(X),True)) == \nVar(false):")	
		println(simplify(And(And(Z,False),Or(X,True))))

		println()
		println("P3: (or 1 x) == \nVar(true):")
		println(simplify(Or(True, X)))
		
		println()
		println("********************* Final Test *********************")
		println("Or(Or(And(Var(A),Var(B)),And(Var(C),Var(D))),E)) == ")
		println("And(And(Or(Or(Var(A),Var(C)),Var(E)),Or(Or(Var(B),Var(C)),Var(E))),And(Or(Or(Var(A),Var(D)),Var(E)),Or(Or(Var(B),Var(D)),Var(E)))):")
		println(simplify(Or(Or(And(A,B),And(C,D)),E)))
		println(simplify(simplify(Or(Or(And(A,B),And(C,D)),E))))
	}//end main method
	
	def simplify(expr:Expr):Expr = {
		var oldExpr = expr
		var newExpr = simplifyMatch(expr)
		
		while(newExpr != oldExpr){
			oldExpr = newExpr
			newExpr = simplifyMatch(oldExpr)
		}//end while loop
		
		newExpr
	}//end simplify method
	
	def simplifyMatch(expr: Expr):Expr = expr match{
		//Simplify Or expressions
		//Absorption Law
		case Or(x,And(y,z)) if x == y => x
		case Or(And(y,z),x) if x == y => z
		//Annulment
		case Or(x, Var("true")) => Var("true")
		case Or(Var("true"), x) => Var("true")
		//Identity
		case Or(x, Var("false")) => simplify(x)
		case Or(Var("false"), x) => simplify(x)
		//Indempotent
		case Or(x, y) if x == y => simplify(x)
		
		case Or(And(w, x), And(y, z)) => Or(And(w, x), And(y, z))
		//Distributive Laws
		case Or(x, And(y, z)) => And(simplify(Or(x, y)), simplify(Or(x, z)))
		case Or(And(y, z), x) => And(simplify(Or(x, y)), simplify(Or(x, z)))
		//Complement
		case Or(x, Not(y)) if x == y => Var("true")
		case Or(Not(x), y) if x == y => Var("true")		
		//recurse again
		case Or(x, y) => Or(simplify(x), simplify(y))
		
		//Simplify And expressions
		//Absorption Law
		case And(x, Or(y,z)) if x == y => x
		case And(Or(y,z),x) if x == y => x
		//Annulment
		case And(x, Var("false")) => Var("false")
		case And(Var("false"), x) => Var("false")
		//Identity
		case And(x, Var("true")) => simplify(x)
		case And(Var("true"), x) => simplify(x)
		//Indempotent
		case And(x, y) if x == y => simplify(x)
		//Complement
		case And(x, Not(y)) if x == y => Var("false")
		case And(Not(x), y) if x == y => Var("false")
		
		case And(Or(w, x), Or(y, z)) => And(Or(w, x), Or(y, z))
		//Distributive Laws
		case And(x, Or(y, z)) => Or(simplify(And(x,y)), simplify(And(x,z)))
		case And(Or(y, z), x) => Or(simplify(And(x,y)), simplify(And(x,z)))
		//recurse again
		case And(x, y) => And(simplify(x), simplify(y))
				
		//Simplify Not expressions
		case Not(Var("true")) => Var("false")
		case Not(Var("false")) => Var("true")
		//Double Negation
		case Not(Not(x)) => simplify(x)
		//DeMorgan's Laws
		case Not(Or(x,y)) => simplify(And(simplify(Not(x)), simplify(Not(y))))
		case Not(And(x,y)) => simplify(Or(simplify(Not(x)), simplify(Not(y))))
		//recurse again
		case Not(x) => Not(simplify(x))	

		//base case
		case x => x
	}//end simplify method
}//end Main class
