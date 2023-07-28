impl Solution {
    pub fn minimum_refill(plants: Vec<i32>, capacity_a: i32, capacity_b: i32) -> i32 {
        
        let mut a = capacity_a;
        let mut b = capacity_b;
        let mut i = 0;
        let mut j = plants.len() - 1;
        let mut refill = 0;
        let mut refill_a = false;
        let mut refill_b = false;
        while i < j {
            if a >= plants[i] {
                a -= plants[i];
                i += 1;
                refill_a = false;
            } else {
                refill_a = true;
            }
            if b >= plants[j] {
                b -= plants[j];
                j -= 1;
                refill_b = false;
            } else {
                refill_b = true;
            }
            if refill_a && refill_b {
                a = capacity_a;
                b = capacity_b;
                refill += 1;
            }
        }
        if i == j {
            if a < plants[i] && b < plants[i] {
                refill += 1;
            }
        }
        refill
    }
}