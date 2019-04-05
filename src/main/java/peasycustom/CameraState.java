/*
   The PeasyCam Processing library, which provides an easy-peasy
   camera for 3D sketching.
  
   Copyright 2008 Jonathan Feinberg

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package peasycustom;

import peasycustom.math.geometry.Rotation;
import peasycustom.math.geometry.Vector3D;
import processing.core.PApplet;
import processing.core.PGraphics;

import java.io.Serializable;

public class CameraState implements Serializable {
	private static final long serialVersionUID = 1L;
	Rotation rotation;
	Vector3D center;
	double distance;

	public CameraState(final Rotation rotation, final Vector3D center,
			final double distance) {
		this.rotation = rotation;
		this.center = center;
		this.distance = distance;
	}

	public boolean isEqual(CameraState cameraState) {
		if(!this.center.isEqual(cameraState.center)) return false;
		if(!this.rotation.isEqual(cameraState.rotation)) return false;
		if(this.distance != cameraState.distance) return false;
		return true;
	}

	public void apply(final PApplet a) {
		if (a.recorder != null) {
			apply(a.recorder);
		}
		apply(a.g);
	}


	public void apply(final PGraphics g) {
		PeasyCam.apply(g, center, rotation, distance);
	}

	public Vector3D getCenter() {
		return center;
	}

	public Rotation getRotation() {
		return rotation;
	}

	public double getDistance() {
		return distance;
	}

	public void setRotation(Rotation rotation) {
		this.rotation = rotation;
	}

	public void setCenter(Vector3D center) {
		this.center = center;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}
