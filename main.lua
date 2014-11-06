display.setStatusBar( display.HiddenStatusBar )

local physics = require( "physics" )
physics.start()
physics.setDrawMode( "hybrid" )
physics.setGravity( 2, 0 )
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------

local center_piece = display.newImage( "ground.png" )
center_piece.x = display.contentCenterX
center_piece.y = display.contentHeight
center_piece.width=display.contentWidth
physics.addBody( center_piece, "static", { friction=0.5, bounce=0.3 } )

--------------------------------------------------------------------------------



--------------------------------------------------------------------------------

local image_name = "star.png"

local image_outline = graphics.newOutline( 2, image_name )

local image_group = display.newGroup()

local function create_body( event )

	if image_group.numChildren >= 40 then

		-- Limit the number of bodies simultaneously on screen.
		image_group[ 1 ]:removeSelf()

	end

	local image_star = display.newImageRect( image_name,
												64,
												64 )

	image_group:insert( image_star )

	image_star.y = math.random( display.contentWidth -100)
	image_star.x = 0

	image_star.rotation = math.random( 360 )

	physics.addBody( image_star, "dynamic", { density = 3.0,
												friction = 0.6,
												bounce = 0.4,
												radius = 30 } )

end

timer.performWithDelay( 800, create_body, 1000 )

--------------------------------------------------------------------------------
