impl Solution {
    pub fn minimum_refill(plants: Vec<i32>, capacity_a: i32, capacity_b: i32) -> i32 {
        
        let mut a = 0;
        let mut b = plants.len() - 1;
        let mut count = 0;
        let mut a_water = 0;
        let mut b_water = 0;
        while a <= b {
            if a_water < plants[a] {
                a_water = capacity_a;
                count += 1;
            }
            if b_water < plants[b] {
                b_water = capacity_b;
                count += 1;
            }
            a_water -= plants[a];
            b_water -= plants[b];
            a += 1;
            if a <= b {
                b -= 1;
            }
        }
        count - 2
    }
}