impl Solution {
    pub fn minimum_refill(plants: Vec<i32>, capacity_a: i32, capacity_b: i32) -> i32 {
        
        let mut a = capacity_a;
        let mut b = capacity_b;
        let mut res = 0;
        let mut i = 0;
        let mut j = plants.len() - 1;
        while i < j {
            if a >= plants[i] {
                a -= plants[i];
                i += 1;
            } else {
                a = capacity_a;
                res += 1;
            }
            if b >= plants[j] {
                b -= plants[j];
                j -= 1;
            } else {
                b = capacity_b;
                res += 1;
            }
        }
        if i == j && a + b < plants[i] {
            res += 2;
        }
        res
    }
}