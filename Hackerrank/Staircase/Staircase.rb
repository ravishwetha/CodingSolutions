#!/bin/ruby

require 'json'
require 'stringio'

# Complete the staircase function below.
def staircase(n)
    1.upto(n).each do |i|
        #row
        1.upto(n).each do |j|
            #column
            if j > n-i
                print '#'
            else
                print ' '
            end       
        end
        puts ''
    end
end

n = gets.to_i

staircase n
