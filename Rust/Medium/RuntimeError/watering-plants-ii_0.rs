impl Solution {
    pub fn minimum_refill(plants: Vec<i32>, capacity_a: i32, capacity_b: i32) -> i32 {
        
        let mut a = capacity_a;
        let mut b = capacity_b;
        let mut i = 0;
        let mut j = plants.len() - 1;
        let mut refill = 0;
        while i <= j {
            if a < plants[i] {
                a = capacity_a;
                refill += 1;
            }
            if b < plants[j] {
                b = capacity_b;
                refill += 1;
            }
            a -= plants[i];
            b -= plants[j];
            i += 1;
            j -= 1;
        }
        refill
    }
}