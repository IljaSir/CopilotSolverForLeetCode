impl Solution {
    pub fn queens_attackthe_king(queens: Vec<Vec<i32>>, king: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut queen_positions = vec![vec![false; 8]; 8];
        for queen in queens {
            queen_positions[queen[0] as usize][queen[1] as usize] = true;
        }
        let mut result = vec![];
        for x in 0..8 {
            for y in 0..8 {
                if queen_positions[x][y] {
                    if x == king[0] as usize {
                        if y < king[1] as usize {
                            let mut is_blocked = false;
                            for i in (y+1)..king[1] as usize {
                                if queen_positions[x][i] {
                                    is_blocked = true;
                                    break;
                                }
                            }
                            if !is_blocked {
                                result.push(vec![x as i32, y as i32]);
                            }
                        } else {
                            let mut is_blocked = false;
                            for i in (king[1] as usize+1)..y {
                                if queen_positions[x][i] {
                                    is_blocked = true;
                                    break;
                                }
                            }
                            if !is_blocked {
                                result.push(vec![x as i32, y as i32]);
                            }
                        }
                    } else if y == king[1] as usize {
                        if x < king[0] as usize {
                            let mut is_blocked = false;
                            for i in (x+1)..king[0] as usize {
                                if queen_positions[i][y] {
                                    is_blocked = true;
                                    break;
                                }
                            }
                            if !is_blocked {
                                result.push(vec![x as i32, y as i32]);
                            }
                        } else {
                            let mut is_blocked = false;
                            for i in (king[0] as usize+1)..x {
                                if queen_positions[i][y] {
                                    is_blocked = true;
                                    break;
                                }
                            }
                            if !is_blocked {
                                result.push(vec![x as i32, y as i32]);
                            }
                        }
                    } else if (x as i32 - king[0]).abs() == (y as i32 - king[1]).abs() {
                        if x < king[0] as usize {
                            if y < king[1] as usize {
                                let mut is_blocked = false;
                                let mut i = x + 1;
                                let mut j = y + 1;
                                while i
    }
}