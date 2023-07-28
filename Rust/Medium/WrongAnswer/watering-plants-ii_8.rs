impl Solution {
    pub fn minimum_refill(plants: Vec<i32>, capacity_a: i32, capacity_b: i32) -> i32 {
        
        let mut a = capacity_a;
        let mut b = capacity_b;
        let mut count = 0;
        for i in 0..plants.len() {
            let p = plants[i];
            if a >= p {
                a -= p;
            } else if b >= p {
                b -= p;
            } else {
                count += 1;
                if capacity_a >= p {
                    a = capacity_a - p;
                    b = 0;
                } else {
                    b = capacity_b - p;
                    a = 0;
                }
            }
        }
        count
    }
}