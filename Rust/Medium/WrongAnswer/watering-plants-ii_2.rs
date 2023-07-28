impl Solution {
    pub fn minimum_refill(plants: Vec<i32>, capacity_a: i32, capacity_b: i32) -> i32 {
        
        let mut a = capacity_a;
        let mut b = capacity_b;
        let mut i = 0;
        let mut j = plants.len() - 1;
        let mut count = 0;
        while i < j {
            if a < plants[i] {
                a = capacity_a;
                count += 1;
            }
            if b < plants[j] {
                b = capacity_b;
                count += 1;
            }
            a -= plants[i];
            b -= plants[j];
            i += 1;
            j -= 1;
        }
        if i == j && a + b < plants[i] {
            count += 1;
        }
        count
    }
}