impl Solution {
    pub fn final_value_after_operations(operations: Vec<String>) -> i32 {
        
        let mut x: i32 = 0;
        for i in operations.iter() {
            if i.contains("++") {
                x += 1;
            } else {
                x -= 1;
            }
        }
        x
    }
}