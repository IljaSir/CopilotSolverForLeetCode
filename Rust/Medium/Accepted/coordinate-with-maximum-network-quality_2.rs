impl Solution {
    pub fn best_coordinate(towers: Vec<Vec<i32>>, radius: i32) -> Vec<i32> {
        
        let mut max_quality = 0;
        let mut max_quality_pos = vec![0, 0];
        for x in 0..51 {
            for y in 0..51 {
                let mut quality = 0;
                for tower in &towers {
                    let dist = ((x - tower[0]).pow(2) + (y - tower[1]).pow(2)) as f64;
                    if dist <= (radius * radius) as f64 {
                        quality += (tower[2] as f64 / (1.0 + dist.sqrt())) as i32;
                    }
                }
                if quality > max_quality {
                    max_quality = quality;
                    max_quality_pos = vec![x, y];
                } else if quality == max_quality {
                    if x < max_quality_pos[0] {
                        max_quality_pos = vec![x, y];
                    } else if x == max_quality_pos[0] && y < max_quality_pos[1] {
                        max_quality_pos = vec![x, y];
                    }
                }
            }
        }
        max_quality_pos
    }
}