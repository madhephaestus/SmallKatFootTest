import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cylinder
import eu.mihosoft.vrl.v3d.Sphere

//Your code here

def radius = 10
def neckRad = 6
def arclen=16.5
def neckThicknes =2
def theta = (arclen*360)/(2.0*3.14159*radius)
def d = Math.sin((theta/2)/180.0*3.14159)*radius

println d

CSG slicer = new Cylinder(radius, neckThicknes).toCSG()
				.difference(new Cylinder(neckRad,neckRad+neckThicknes, neckThicknes,15).toCSG())
				.toZMax()
				.movez(d)
CSG slicer2 = new Cylinder(radius*2, radius*2).toCSG().toZMax()
				.movez(d-neckThicknes)

CSG ball  = new Sphere(radius,32, 16).toCSG()
				.difference(slicer)
				//.difference(slicer2)
				.union(new Cylinder(radius-2, 10).toCSG().toZMax())
				
				