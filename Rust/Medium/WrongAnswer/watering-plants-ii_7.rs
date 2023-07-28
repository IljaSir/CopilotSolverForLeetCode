impl Solution {
    pub fn minimum_refill(plants: Vec<i32>, capacity_a: i32, capacity_b: i32) -> i32 {
        
        let mut a = 0;
        let mut b = plants.len() - 1;
        let mut refill = 0;
        let mut a_water = capacity_a;
        let mut b_water = capacity_b;
        while a <= b {
            if a_water < plants[a] {
                a_water = capacity_a;
                refill += 1;
            }
            if b_water < plants[b] {
                b_water = capacity_b;
                refill += 1;
            }
            if a_water >= plants[a] && b_water >= plants[b] {
                a_water -= plants[a];
                b_water -= plants[b];
                a += 1;
                if a < b {
                    b -= 1;
                }
            } else if a_water >= plants[a] {
                a_water -= plants[a];
                a += 1;
            } else if b_water >= plants[b] {
                b_water -= plants[b];
                b -= 1;
            }
        }
        refill
    }
}