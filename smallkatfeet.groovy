import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cylinder
import eu.mihosoft.vrl.v3d.Sphere

//Your code here

def radius = 10
def neckRad = 6
def arclen=18.5
def neckThicknes =3.5
def theta = (arclen*360)/(2.0*3.14159*radius)
def internalAngle = (90-(theta/2))
def d = Math.sin(Math.toRadians(internalAngle))*radius

println d +" "+theta+" cir="+(3.14159*radius)+ " ind angle="+internalAngle

CSG slicer = new Cylinder(radius*2, neckThicknes).toCSG()
				.difference(new Cylinder(neckRad,neckRad+neckThicknes, neckThicknes,15).toCSG())
				.toZMax()
				.movez(d)
CSG slicer2 = new Cylinder(radius*2, radius*2).toCSG().toZMax()
				.movez(d-neckThicknes-5)

CSG ball  = new Sphere(radius,32, 16).toCSG()
				.difference(slicer)
				.difference(slicer2)
				//.union(new Cylinder(radius-2, 10).toCSG().toZMax())
				
				