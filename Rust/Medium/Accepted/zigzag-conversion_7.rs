impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        

        let mut result: String = String::new();
        if num_rows == 1 {
            return s;
        }
        let mut step = 2 * num_rows - 2;
        for i in 0..num_rows {
            let mut j = i;
            while j < s.len() as i32 {
                result.push(s.chars().nth(j as usize).unwrap());
                if i != 0 && i != num_rows - 1 && j + step - 2 * i < s.len() as i32 {
                    result.push(s.chars().nth((j + step - 2 * i) as usize).unwrap());
                }
                j += step;
            }
        }
        result
    }
}