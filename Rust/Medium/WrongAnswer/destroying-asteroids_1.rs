impl Solution {
    pub fn asteroids_destroyed(mass: i32, asteroids: Vec<i32>) -> bool {
        
        let mut mass = mass;
        let mut asteroids = asteroids;
        asteroids.sort();
        for i in 0..asteroids.len() {
            if mass >= asteroids[i] {
                mass += asteroids[i];
            } else {
                return false;
            }
        }
        true
    }
}