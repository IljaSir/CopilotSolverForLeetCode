impl Solution {
    pub fn largest_altitude(gain: Vec<i32>) -> i32 {
        
        let mut highest = 0;
        let mut current = 0;
        for i in gain {
            current += i;
            if current > highest {
                highest = current;
            }
        }
        highest
    }
}