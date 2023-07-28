impl Solution {
    pub fn minimum_refill(plants: Vec<i32>, capacity_a: i32, capacity_b: i32) -> i32 {
        
        let mut res = 0;
        let mut a = 0;
        let mut b = 0;
        let mut i = 0;
        let mut j = plants.len() - 1;
        while i <= j {
            if a < plants[i] {
                a = capacity_a;
                res += 1;
            }
            if b < plants[j] {
                b = capacity_b;
                res += 1;
            }
            a -= plants[i];
            b -= plants[j];
            i += 1;
            j -= 1;
        }
        if a >= plants[i - 1] && b >= plants[j + 1] {
            res -= 1;
        }
        res
    }
}