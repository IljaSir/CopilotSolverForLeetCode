impl Solution {
    pub fn remove_stones(stones: Vec<Vec<i32>>) -> i32 {
        
        let mut dsu = Dsu::new(stones.len());
        let mut x_to_y = HashMap::new();
        let mut y_to_x = HashMap::new();
        
        for (i, stone) in stones.iter().enumerate() {
            let x = stone[0];
            let y = stone[1];
            
            if let Some(j) = x_to_y.get(&x) {
                dsu.merge(i, *j);
            }
            if let Some(j) = y_to_x.get(&y) {
                dsu.merge(i, *j);
            }
            
            x_to_y.insert(x, i);
            y_to_x.insert(y, i);
        }
        
        stones.len() as i32 - dsu.count
    }
}